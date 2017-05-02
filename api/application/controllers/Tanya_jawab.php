
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
class Tanya_jawab extends REST_Controller {

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
    
    public function list_kategori_post($page)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("select * from ask_category")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_pertanyaan_post($page)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("select * from v_asks")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_jawaban_post()
    {
        // Users from a data store e.g. database
        $this->db->where("id_ask",$this->post("id_pertanyaan"));
        $response = $this->db->query("select * from v_ask_comments")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function insert_pertanyaan_post($id_profile,$pertanyaan)
    {
        // Users from a data store e.g. database
        $insert["id_profile"] = $this->post("id_profile");
        $insert["id_ask_category"] = $this->post("id_ask_category");
        $insert["ask"] = $this->post("ask");
        $insert["point"] = $this->post("point");
        $insert["answered"] = 0;
        $insert["solved"] = null;
        $insert["created"] = date("Y-m-d H:i:s");

        $this->db->insert("demo1_idisi.ask",$insert);
        $response["status"] = "success";
        
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function add_jawaban_post($id_profile,$id_pertanyaan,$jawaban)
    {
        // Users from a data store e.g. database
        $insert["id_profile"] = $this->post("id_profile");
        $insert["id_ask"] = $this->post("id_ask");
        $insert["text"] = $this->post("text");
        $insert["date"] = date("Y-m-d H:i:s");

        $this->db->insert("demo1_idisi.ask_comments",$insert);
        $response["status"] = "success";
			
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function delete_pertanyaan_post()
    {
        // Users from a data store e.g. database
        $this->db->where("id",$this->post("id_pertanyaan"));
        $this->db->delete("demo1_idisi.ask");
        $response["status"] = "success";
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function delete_jawaban_post()
    {
        // Users from a data store e.g. database
        $this->db->where("id",$this->input->post("id_jawaban"));
        $this->db->delete("demo1_idisi.ask_comments");
        $response["status"] = "success";
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
}
