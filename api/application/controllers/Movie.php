
<?php

defined('BASEPATH') OR exit('No direct script access allowed');

// This can be removed if you use __autoload() in config.php OR use Modular Extensions
/** @noinspection PhpIncludeInspection */
require APPPATH . '/libraries/REST_Controller.php';

// use namespace
use Restserver\Libraries\REST_Controller;

/**
 * This is an example of a few basic user interaction methods you could use
 * all done with a hardcoded array
 *
 * @package         CodeIgniter
 * @subpackage      Rest Server
 * @category        Controller
 * @author          Phil Sturgeon, Chris Kacerguis
 * @license         MIT
 * @link            https://github.com/chriskacerguis/codeigniter-restserver
 */
class Movie extends REST_Controller {

    function __construct()
    {
        // Construct the parent class
        parent::__construct();

        // Configure limits on our controller methods
        // Ensure you have created the 'limits' table and enabled 'limits' within application/config/rest.php
        //$this->methods['users_get']['limit'] = 500; // 500 requests per hour per user/key
        //$this->methods['users_post']['limit'] = 100; // 100 requests per hour per user/key
        //$this->methods['users_delete']['limit'] = 50; // 50 requests per hour per user/key
    }
    public function top_rated_get()
    {
        /*
        $result["page"] = "1";
        $result["total_results"] = 6012;
        $result["total_pages"] = 301;
        */
        //echo file_get_contents("http://api.themoviedb.org/3/movie/top_rated?api_key=7e8f60e325cd06e164799af1e317d7a7");
        $result["results"] = $this->db->get("movies")->result_array();
        $this->set_response($result, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }    
    public function list_data_get()
    {
        $result["results"] = $this->db->get("movies")->result_array();
        $this->set_response($result, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
}
