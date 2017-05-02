
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
class GroupKelas extends REST_Controller {

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

    public function list_kelas($page)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('list','','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function add_kelas($nip,$nama_kelas)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('add','{$nip}','{$nama_kelas}','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    
    public function list_posting($id_kelas)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('list_posting','{$id_kelas}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function add_posting($nip,$content)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('add_posting','{$nip}','{$content}','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function delete_posting($id_posting)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('delete_posting','{$id_posting}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    
    public function list_obrolan($id_kelas)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('list_obrolan','{$id_kelas}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function add_obrolan($nip,$id_kelas,$obrolan)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('add_obrolan','{$nip}','{$id_kelas}','{$obrolan}')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_members($id_kelas)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('list_members','{$id_kelas}','','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_members($id_kelas,$id_members)
    {
        // Users from a data store e.g. database
        $response = $this->db->query("call group_kelas('delete_members','{$id_kelas}','{$id_members}','')");
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
}
