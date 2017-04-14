
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
class TanyaJawab extends REST_Controller {

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

    public function list_pertanyaan($page)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call tanya_jawab('list','{$page}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_jawaban($id_pertanyaan)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call tanya_jawab('list_jawaban','{$id_pertanyaan}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function insert_pertanyaan($id_profile,$pertanyaan)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call tanya_jawab('insert','{$id_profile}','{$pertanyaan}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function add_jawaban($id_profile,$id_pertanyaan,$jawaban)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call tanya_jawab('insert_jawaban','{$id_profile}','{$id_pertanyaan}','{$jawaban}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function delete_pertanyaan($id_pertanyaan)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call jadwal('delete','{$id_pertanyaan}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function delete_jawaban($id_jawaban)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call jadwal('delete_jawaban','{$id_jawaban}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
}
