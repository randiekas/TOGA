
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
class Itelu extends REST_Controller {

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
        $username = $this->get("username");
        $password = $this->get("password");
        
        $this->db->where("username",$username);
        $this->db->where("password",$password);
        $Q = $this->db->get("itelu_user");
        if($Q->num_rows()>=1)
        {
            $response = $Q->row_array();
            $response["status"] = "success";
            $response["message"] = "Login berhasil";
        }else{
            $response["status"] = "error";
            $response["message"] = "User tidak ditemukan .";
        }
        
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function signup_get()
    {
        $username = $this->input->get("username");
        $password = $this->input->get("password");
        
        $this->db->where("username",$username);
        $this->db->where("password",$password);
        $Q = $this->db->get("itelu_user");
        if($Q->num_rows()>=1)
        {
            $response["status"] = "error";
            $response["message"] = "Username sudah terdaftar";
        }else{
            $insert["username"] = $username;
            $insert["password"] = $password;
            $this->db->insert("itelu_user",$insert);    
            $response["status"] = "success";
            $response["message"] = "Selamat anda berhasil mendaftar, silahkan klik login";
        }
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
}
