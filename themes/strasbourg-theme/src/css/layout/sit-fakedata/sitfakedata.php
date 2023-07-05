<?php
/*
    Plugin Name: SIT : Jeu de fausses données pour le starter
    Plugin URI: https://www.thuria.com
    Description:
    Version: 1.0.0
    Author: Thuria
    Author URI: https://www.thuria.com
    License: GPLv2 or later
    License URI: http://www.gnu.org/licenses/gpl-2.0.html
*/

class SITFakeData
{

    public function __construct()
    {
        $this->loadRequires(true);

        if (is_admin()) {
            // action à l'installation du plugin
            add_action('activated_plugin', [$this, 'install']);
        }
    }

    function loadRequires($load_posttype = false)
    {
        if ($load_posttype == true) {
            foreach (glob(__DIR__ . "/post_type/*.php") as $filename) {
                include_once $filename;
            }
        }
    }

    static function getJsonData($post_id)
    {
        $post_to_jsondata = [
            1271 => 'ASCBRE022FS0002M.json',
            1272 => 'HOTBRE0220H00121.json',
            1273 => 'ITIBRE022V50C8GL.json',
            1274 => 'ITIBRE022V537Y1E.json',
            1293 => '940005049.json',
            1294 => '940004811.json',
            1295 => '940008559.json',
            1296 => '255003204.json',
            1297 => '255005013.json',
            1298 => '255005161.json',
            1299 => '255005741.json',
            1300 => '255000058.json',
            2037 => 'apidae_6192051.json',
            2038 => 'apidae_5322520.json',
            2039 => 'apidae_5327453.json',
        ];

        $json_decode = json_decode(
            file_get_contents(WP_PLUGIN_DIR . '/sit-fakedata/json/' . $post_to_jsondata[$post_id]),
            ARRAY_N
        );

        return $json_decode;
    }

    static function getCoverType($post_id)
    {
        $post_to_jsondata = [
            1271 => 'gallery',
            1272 => 'gallery',
            1273 => 'gallery',
            1274 => 'gallery',
            1293 => 'full',
            1294 => 'full',
            1295 => 'full',
            1296 => 'gallery',
            1297 => 'gallery',
            1298 => 'gallery',
            1299 => 'gallery',
            1300 => 'gallery',
            2037 => 'gallery',
            2038 => 'full',
            2039 => 'full',
        ];

        return $post_to_jsondata[$post_id];
    }


}

new  SITFakeData();