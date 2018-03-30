
$(document).ready(function(){
	var slides = [{src: 'Public/Images/a1.jpg'}, {src: 'Public/Images/a2.jpg'}, {src: 'Public/Images/a3.jpg'}, {src:'Public/Images/a4.jpg'},{src: 'Public/Images/a5.jpg'}]
	var jR3DCarousel;
	var carouselProps =  {
			 		  width: 550, 				/* largest allowed width */
					  height: 470, 				/* largest allowed height */
					  slideLayout : 'fill',     /* "contain" (fit according to aspect ratio), "fill" (stretches object to fill) and "cover" (overflows box but maintains ratio) */
					  animation: 'slide3D', 		/* slide | scroll | fade | zoomInSlide | zoomInScroll */
					  animationCurve: 'ease',
					  animationDuration: 2000,  /*控制动画加载完成的时间*/
					  animationInterval: 2000,  /*控制轮播速度*/
					  //slideClass: 'jR3DCarouselCustomSlide',
					  autoplay: true,           /*是否自动播放*/
					  onSlideShow: show,		/* callback when Slide show event occurs */
					  navigation: 'circles',	/* circles | squares */
					  slides: slides 			/* array of images source or gets slides by 'slide' class */
						  
				}
	function setUp(){
 		jR3DCarousel = $('.jR3DCarouselGallery').jR3DCarousel(carouselProps);

		$('.settings').html('<pre>$(".jR3DCarouselGallery").jR3DCarousel('+JSON.stringify(carouselProps, null, 4)+')</pre>');		
		
	}
	function show(slide){
		console.log("Slide shown: ", slide.find('img').attr('src'))
	}
	$('.carousel-props input').change(function(){
		if(isNaN(this.value))
			carouselProps[this.name] = this.value || null; 
		else
			carouselProps[this.name] = Number(this.value) || null; 
		
		for(var i = 0; i < 999; i++)
	     clearInterval(i);
		$('.jR3DCarouselGallery').empty();
		setUp();
		jR3DCarousel.showNextSlide();
	})
	
	$('[name=slides]').change(function(){
		carouselProps[this.name] = getSlides(this.value); 
		for (var i = 0; i < 999; i++)
	     clearInterval(i);
		$('.jR3DCarouselGallery').empty();
		setUp();
		jR3DCarousel.showNextSlide();		
	});
	
	function getSlides(no){
		slides = [];
		for ( var i = 0; i < no; i++) {
			slides.push({src: 'https://unsplash.it/'+Math.floor(1366-Math.random()*200)+''+Math.floor(768+Math.random()*200)})
		}
		return slides;
	}
	
	//carouselProps.slides = getSlides(7);
	setUp()

  })
