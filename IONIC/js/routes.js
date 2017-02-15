angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    
  

      .state('tabsController.menu', {
    url: '/menu',
    views: {
      'tab1': {
        templateUrl: 'templates/menu.html',
        controller: 'menuCtrl'
      }
    }
  })

  .state('tabsController.pesan', {
    url: '/pesan',
    views: {
      'tab2': {
        templateUrl: 'templates/pesan.html',
        controller: 'pesanCtrl'
      }
    }
  })

  .state('tabsController.bantuan', {
    url: '/bantuan',
    views: {
      'tab3': {
        templateUrl: 'templates/bantuan.html',
        controller: 'bantuanCtrl'
      }
    }
  })

  .state('tabsController', {
    url: '/page1',
    templateUrl: 'templates/tabsController.html',
    abstract:true
  })

  .state('tabsController.akun', {
    url: '/akun',
    views: {
      'tab4': {
        templateUrl: 'templates/akun.html',
        controller: 'akunCtrl'
      }
    }
  })

  .state('tabsController.berita', {
    url: '/berita',
    views: {
      'tab1': {
        templateUrl: 'templates/berita.html',
        controller: 'beritaCtrl'
      }
    }
  })

  .state('tabsController.detailBerita', {
    url: '/berita_detail',
    views: {
      'tab1': {
        templateUrl: 'templates/detailBerita.html',
        controller: 'detailBeritaCtrl'
      }
    }
  })

  .state('tabsController.jadwalMengajar', {
    url: '/jadwal_mengajar',
    views: {
      'tab1': {
        templateUrl: 'templates/jadwalMengajar.html',
        controller: 'jadwalMengajarCtrl'
      }
    }
  })

  .state('tabsController.kehadiranSiswa', {
    url: '/jadwal_kehadiran',
    views: {
      'tab1': {
        templateUrl: 'templates/kehadiranSiswa.html',
        controller: 'kehadiranSiswaCtrl'
      }
    }
  })

  .state('tabsController.belumTerjawab', {
    url: '/tanya_jawab_belum',
    views: {
      'tab1': {
        templateUrl: 'templates/belumTerjawab.html',
        controller: 'belumTerjawabCtrl'
      }
    }
  })

  .state('tabsController.sudahTerjawab', {
    url: '/tanya_jawab_sudah',
    views: {
      'tab1': {
        templateUrl: 'templates/sudahTerjawab.html',
        controller: 'sudahTerjawabCtrl'
      }
    }
  })

  .state('tabsController.detailPertanyaan', {
    url: '/tanya_jawab_detail',
    views: {
      'tab1': {
        templateUrl: 'templates/detailPertanyaan.html',
        controller: 'detailPertanyaanCtrl'
      }
    }
  })

  .state('tabsController.buatPertanyaan', {
    url: '/tanya_jawab_buat',
    views: {
      'tab1': {
        templateUrl: 'templates/buatPertanyaan.html',
        controller: 'buatPertanyaanCtrl'
      }
    }
  })

  .state('tabsController.groups', {
    url: '/group_list',
    views: {
      'tab1': {
        templateUrl: 'templates/groups.html',
        controller: 'groupsCtrl'
      }
    }
  })

  .state('tabsController.buatGroupBaru', {
    url: '/group_buat',
    views: {
      'tab1': {
        templateUrl: 'templates/buatGroupBaru.html',
        controller: 'buatGroupBaruCtrl'
      }
    }
  })

  .state('tabsController.groupPosting', {
    url: '/group_posting',
    views: {
      'tab1': {
        templateUrl: 'templates/groupPosting.html',
        controller: 'groupPostingCtrl'
      }
    }
  })

  .state('tabsController.groupMember', {
    url: '/group_member',
    views: {
      'tab1': {
        templateUrl: 'templates/groupMember.html',
        controller: 'groupMemberCtrl'
      }
    }
  })

  .state('tabsController.groupObrolan', {
    url: '/group_obrolan',
    views: {
      'tab1': {
        templateUrl: 'templates/groupObrolan.html',
        controller: 'groupObrolanCtrl'
      }
    }
  })

  .state('tabsController.detailPosting', {
    url: '/group_posting_detail',
    views: {
      'tab1': {
        templateUrl: 'templates/detailPosting.html',
        controller: 'detailPostingCtrl'
      }
    }
  })

  .state('tabsController.tambahkanCatatan', {
    url: '/group_posting_buat',
    views: {
      'tab1': {
        templateUrl: 'templates/tambahkanCatatan.html',
        controller: 'tambahkanCatatanCtrl'
      }
    }
  })

  .state('tabsController.nilaiSiswa', {
    url: '/nilai',
    views: {
      'tab1': {
        templateUrl: 'templates/nilaiSiswa.html',
        controller: 'nilaiSiswaCtrl'
      }
    }
  })

  .state('tabsController.komponenNilai', {
    url: '/nilai_komponen',
    views: {
      'tab1': {
        templateUrl: 'templates/komponenNilai.html',
        controller: 'komponenNilaiCtrl'
      }
    }
  })

  .state('tabsController.tambahKomponenNilai', {
    url: '/nilai_komponen_tambah',
    views: {
      'tab1': {
        templateUrl: 'templates/tambahKomponenNilai.html',
        controller: 'tambahKomponenNilaiCtrl'
      }
    }
  })

  .state('tabsController.inputNilaiSiswa', {
    url: '/nilai_input',
    views: {
      'tab1': {
        templateUrl: 'templates/inputNilaiSiswa.html',
        controller: 'inputNilaiSiswaCtrl'
      }
    }
  })

$urlRouterProvider.otherwise('/page1/menu')

  

});