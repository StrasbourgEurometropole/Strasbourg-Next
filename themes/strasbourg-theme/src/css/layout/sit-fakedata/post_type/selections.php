<?php


class SelectionsFakesitTaxonomy
{

    static $key = 'fakesit_selections';

    public function __construct()
    {
        add_action("init", [$this, "init"]);
    }


    public function init()
    {
        $this->createTaxonomy();
    }


    public function createTaxonomy()
    {
        $labels = array(
            'name' => 'Selections FakeSIT',
            'singular_name' => 'Selection FakeSIT',
            'menu_name' => 'Selections FakeSIT',
            "all_items" => __("Toutes les Selections FakeSIT", "text_domain"),
            "new_item_name" => __("Nom de la Selection FakeSIT", "text_domain"),
            "add_new_item" => __("Ajouter une Selection FakeSIT", "text_domain"),
            "edit_item" => __("Modifier la Selection FakeSIT", "text_domain"),
            "update_item" => __("Mettre à jour la Selection FakeSIT", "text_domain"),
            "view_item" => __("Voir la Selection FakeSIT", "text_domain"),
            "add_or_remove_items" => __("Ajouter ou enlever des Selections FakeSIT", "text_domain"),
            "choose_from_most_used" => __("Choisir parmis les plus utilisés", "text_domain"),
            "popular_items" => __("Selections FakeSIT populaires", "text_domain"),
            "search_items" => __("Chercher des Selections FakeSIT", "text_domain"),
            "not_found" => __("Non trouvé", "text_domain"),
            "no_terms" => __("Pas de Selections FakeSIT", "text_domain"),
            "items_list" => __("Items list", "text_domain"),
            "items_list_navigation" => __("Items list navigation", "text_domain"),
        );
        $args = array(
            'labels' => $labels,
            'hierarchical' => true,
            'public' => true,
            'show_ui' => true,
            'show_admin_column' => true,
            'show_in_nav_menus' => true,
            'show_tagcloud' => false,
            'rewrite' => array(
                'with_front' => false,
                'slug' => 'FakeSIT'
            )
        );

        register_taxonomy(self::$key, array('fakesit'), $args);
    }

    function addTaxonomyToPLL($taxonomies, $is_settings)
    {
        if ($is_settings) {
            // hides 'my_cpt' from the list of custom post types in Polylang settings
            unset($taxonomies[self::$key]);
        } else {
            // enables language and translation management for 'my_cpt'
            $taxonomies[self::$key] = self::$key;
        }
        return $taxonomies;
    }
}

new SelectionsFakesitTaxonomy();
