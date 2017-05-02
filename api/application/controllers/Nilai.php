
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
class Nilai extends REST_Controller {

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

    public function list_mengajar_post($nip)
    {
        // Users from a data store e.g. database
        $response = $this->db->get('sync_pilih_kelas')->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    public function list_siswa_post($nip)
    {
        // Users from a data store e.g. database
        $this->db->select("nis,nama");
		$this->db->where("idtahunajaran",$this->post("idtahunajaran"));
		$this->db->where("idkelas",$this->post("idkelas"));
		$this->db->order_by("nama","asc");
		$response = $this->db->get('sync_v_siswa')->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
    
    public function list_nilai_post($id_kelas)
    {
        // Users from a data store e.g. database
        $idkelas = $this->post("idkelas");
		$idsemester = $this->post("idsemester");
		$nis = $this->post("nis");
		$nip = $this->post("nip");
        
		$response = $this->db->query("call sync_nau_rapor_perguru('{$idkelas}','{$idsemester}','{$nis}','{$nip}')")->result();
        $this->set_response($response, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    }
}
