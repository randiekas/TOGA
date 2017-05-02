
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
class Jadwal extends REST_Controller {

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
        $nip = $this->post('nip');
        $departemen = "SMK";
        $infojadwal = "4";
        
        $response["results"] = $this->db->query("call jadwal('list','{$nip}','{$departemen}','{$infojadwal}')")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_get()
    {
        $result["results"] = $this->db->get("jadwal")->result_array();
        $this->set_response($result, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code

    }
    public function list_absensi_header_post()
    {
        $this->db->where("idkelas",$this->post("idkelas"));
        $this->db->where("idsemester",$this->post("idsemester"));
        $this->db->where("idpelajaran",$this->post("idpelajaran"));
        $this->db->where("gurupelajaran",$this->post("nip"));
        $this->db->where("tanggal",$this->post("tanggal"));
        $response = $this->db->get('sync_presensi')->last_row();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_absensi_list_post()
	{
			$this->db->where("idkelas",$this->post("idkelas"));
            $this->db->where("idsemester",$this->post("idsemester"));
            $this->db->where("idpelajaran",$this->post("idpelajaran"));
            $this->db->where("gurupelajaran",$this->post("nip"));
            $this->db->where("tanggal",$this->post("tanggal"));
			$response = $this->db->get('sync_presensisiswainput')->result();
		    $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
	}
}
