
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
class Kelas extends REST_Controller {

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

    public function list_post()
    {
        
        // Users from a data store e.g. database
        
        $id_profile = $this->post('id_profile');
        $this->db->where("id_profile",$id_profile);
        
        $response["results"] = $this->db->get("v_groups_members")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
        
        /*
        $response["results"] = $this->db->query("select * from ask_category")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
        */
    }    
    public function list_posting_post()
    {
        $this->db->where("id_group",$this->post('id_kelas'));
        $response["results"] = $this->db->get("v_groups_posts")->result();
        
		$this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code   
    }
    public function add_posting_post()
    {
        // Users from a data store e.g. database
        $data["id_group"] = $this->post("id_group");
        $data["id_profile"] = $this->post("id_profile");
        $data["tipe"] = "Catatan";
        $data["text"] = $this->post("text");
        $data["date"] = date("Y-m-d H:i:s");
        $data["likes"] = "0";
        $data["comments"] = "0";
        $this->db->insert("demo1_idisi.groups_posts",$data);
        $response["status"] = "success";
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    
    public function obrolan_post()
    {
        // Users from a data store e.g. database
        $this->db->where("id_group",$this->post("id_kelas"));
        $response["results"] = $this->db->get("v_groups_chat")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function add_obrolan_post($nip,$id_kelas,$obrolan)
    {
        // Users from a data store e.g. database
        $id_group = $this->post("id_group");
        $id_profile = $this->post("id_profile");
        $message = $this->post("message");
        $this->db->query("call demo1_idisi.ins_chat('".$id_group."','".$id_profile."','".$message."');");
        
        $response["status"] = "success";
        
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function members_post()
    {
        $id_group = $this->post("id_group");
        $id_profile = $this->post("id_profile");
        
        $response["results"] = $this->db->query("call demo1_idisi.app_groups('members','{$id_profile}','{$id_group}')")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
}
