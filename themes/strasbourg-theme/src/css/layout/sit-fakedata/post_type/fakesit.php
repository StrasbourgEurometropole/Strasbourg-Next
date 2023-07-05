<?php


class PostTypeFakesit
{

    public function __construct()
    {
        add_action('init', [$this, 'setPostType'], 0);

        // Gestion du breadcrumb des
        add_filter('th_breadrumb_filter', [$this, 'breadcrumb']);
    }

    public function setPostType()
    {
        $labels = array(
            'name' => _x('Fake SIT', 'Post Type General Name', 'text_domain'),
            'singular_name' => _x('Fake SIT', 'Post Type Singular Name', 'text_domain'),
            'menu_name' => __('Fake SIT', 'text_domain'),
            'name_admin_bar' => __('Fake SIT', 'text_domain'),
        );


        $args = array(
            'label' => 'Fake SIT',
            'labels' => $labels,
            'supports' => array('title', 'editor', 'custom-fields'),
            'hierarchical' => false,
            'public' => true,
            'show_ui' => true,
            'show_in_menu' => true,
            'menu_position' => 5,
            'menu_icon' => 'dashicons-image-filter',
            'show_in_admin_bar' => false,
            'show_in_nav_menus' => true,
            'can_export' => true,
            'has_archive' => true,
            'exclude_from_search' => false,
            'publicly_queryable' => true,
            'capability_type' => 'page',
            'rewrite' => array(
                'with_front' => false,
                'slug' => 'sit'
            )
        );


        register_post_type('fakesit', $args);
    }

    function breadcrumb($breadcrumb)
    {
        if (is_singular("fakesit")) {
            global $post;

            $breadcrumb->remove(1);
            $breadcrumb->remove(2);

            if (isset($breadcrumb->list) && is_array($breadcrumb->list)) {
                // Récupération du slug SIT de la fiche en récupérerant les sélections dont la fiche est, et les slugs que possède ces sélections
                $selections_of_post = get_the_terms($post, "tourinsoft_selections");


                if ($selections_of_post && is_array($selections_of_post)) {
                    $slug_to_take = null;
                    $priority = null;

                    foreach ($selections_of_post as $selection) {
                        $slugs_query = new WP_Term_Query(
                            [
                                "taxonomy" => "slug_sit",
                                "hide_empty" => false,
                                "orderby" => "priority",
                                "order" => "asc",
                                "meta_query" => [
                                    [
                                        "key" => "selectionstourinsoft_selections",
                                        "value" => $selection->term_id,
                                        "compare" => "LIKE"
                                    ],
                                    "priority" => [
                                        "key" => "priority",
                                        "type" => "NUMERIC"
                                    ]
                                ]
                            ]
                        );

                        if (isset($slugs_query->terms[0])) {
                            // Il faut calculer la priorité, si la priorité du noueveau terme est supérieure à celle qu'on a déjà, on remplace le slug_to_take et la priorité de base
                            $new_priority = (int)get_term_meta($slugs_query->terms[0]->term_id, "priority", true);

                            if ($priority) {
                                if ($new_priority < $priority) {
                                    $priority = $new_priority;
                                    $slug_to_take = $slugs_query->terms[0];
                                }
                            } else {
                                $slug_to_take = $slugs_query->terms[0];

                                $priority = $new_priority;
                            }
                        }
                    }

                    if ($slug_to_take) {
                        // Récupération des pages du slug pour construire le breadcrumb
                        $page = get_field("breadcrumb_page", $slug_to_take);

                        if ($page) {
                            //Get evetual ancestor's ancestor
                            $anc = get_post_ancestors($page->ID);
                            if (count($anc) > 0) {
                                // Get parents in the right order
                                $anc = array_reverse($anc);

                                // Parent page loop
                                if (!isset($parents)) {
                                    $parents = null;
                                }
                                foreach ($anc as $ancestor) {
                                    $titreAncestor = @get_field("cover_data", $ancestor)['titre'];
                                    if ($titreAncestor && $titreAncestor != '') {
                                        $breadcrumb->add(get_permalink($ancestor), $titreAncestor);
                                    } else {
                                        $breadcrumb->add(get_permalink($ancestor), get_the_title($ancestor));
                                    }
                                }
                            }

                            $breadcrumb->add(get_permalink($page->ID), $page->post_title);
                        }
                    }
                }
            }

            $breadcrumb->add(false, get_the_title($post->ID));
        }

        return $breadcrumb;
    }

}

new PostTypeFakesit();


/**
 * Enable polylang multilang post type
 */
add_filter('pll_get_post_types', 'add_fakesit_cpt_to_pll', 10, 2);
function add_fakesit_cpt_to_pll($post_types, $is_settings)
{
    if ($is_settings) {
        // hides 'my_cpt' from the list of custom post types in Polylang settings
        unset($post_types['fakesit']);
    } else {
        // enables language and translation management for 'my_cpt'
        $post_types['fakesit'] = 'fakesit';
    }
    return $post_types;
}
