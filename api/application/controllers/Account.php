
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
class Account extends REST_Controller {

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

    public function signin_get()
    {
        // Users from a data store e.g. database
        $response["status"]= "success";
        $response["message"]= "selamat datang :D";
        $response["email"]= "";
        $response["foto"]= "http://scientic.sakolah.com/assets/pegawai/197602192005071001/197602192005071001.jpg";
        $response["gender"]= "L";
        $response["id"]= "15";
        $response["image"]= null;
        $response["name"]= "Yudi Subekti";
        $response["nomor_induk"]= "197602192005071001 datang";
        $response["password"]= "bismilah";
        $response["school"]= "smkn11bdg";
        $response["tingkat"]= null;
        $response["type"]= 2;
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function signin_post()
    {
        // Users from a data store e.g. database
        $username = $this->post("username");
        $password = $this->post("password");
        
        $response = $this->db->query("call account('signin','2','{$username}','{$password}');")->last_row();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_message_header($id_profile)
    {
        
        $response = $this->db->query("call account('list_message_header','{$id_profile}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_message($id_message)
    {
        $response = $this->db->query("call account('list_message','{$id_message}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function add_message($id_message,$id_profile,$message)
    {
        $response = $this->db->query("call account('list_message','{$id_message}','{$id_profile}','{$message}')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function logout()
    {
        // Users from a data store e.g. database
        $response["status"]= "success";
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
}
