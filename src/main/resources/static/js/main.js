$(document).ready(function() {
 
    $(".owl-carousel").on("initialized.owl.carousel", () => {
        setTimeout(() => {
          $(".owl-item.active .owl-slide-animated").addClass("is-transitioned");
          $("section").show();
        }, 200);
      });
      const $owlCarousel = $(".owl-carousel").owlCarousel({
        items: 1,
        loop: true,
        nav: true,
        navText: [
          '<svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M12 0c6.623 0 12 5.377 12 12s-5.377 12-12 12-12-5.377-12-12 5.377-12 12-12zm0 1c6.071 0 11 4.929 11 11s-4.929 11-11 11-11-4.929-11-11 4.929-11 11-11zm3 5.753l-6.44 5.247 6.44 5.263-.678.737-7.322-6 7.335-6 .665.753z"/></svg>',
          '<svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M12 0c6.623 0 12 5.377 12 12s-5.377 12-12 12-12-5.377-12-12 5.377-12 12-12zm0 1c6.071 0 11 4.929 11 11s-4.929 11-11 11-11-4.929-11-11 4.929-11 11-11zm-3 5.753l6.44 5.247-6.44 5.263.678.737 7.322-6-7.335-6-.665.753z"/></svg>' //icons from https://iconmonstr.com */
        ]
      });

      
      $owlCarousel.on("changed.owl.carousel", e => {
        $(".owl-slide-animated").removeClass("is-transitioned");
      
        const $currentOwlItem = $(".owl-item").eq(e.item.index);
        $currentOwlItem.find(".owl-slide-animated").addClass("is-transitioned");
      
        const $target = $currentOwlItem.find(".owl-slide-text");
        doDotsCalculations($target);
      });
      
      $owlCarousel.on("resize.owl.carousel", () => {
        setTimeout(() => {
          setOwlDotsPosition();
        }, 50);
      });
      
      /*if there isn't content underneath the carousel*/
      $owlCarousel.trigger("refresh.owl.carousel");
      
      setOwlDotsPosition();
      
      function setOwlDotsPosition() {
        const $target = $(".owl-item.active .owl-slide-text");
        doDotsCalculations($target);
      }
      
      function doDotsCalculations(el) {
        const height = el.height();
        const {top, left} = el.position();
        const res = height + top + 20;
      
        $(".owl-carousel .owl-dots").css({
          top: `${res}px`,
          left: `${left}px`
        });
      }
 
  });

  
  

  
  