$(function () {


	//jQuery Validate 琛ㄥ崟楠岃瘉
	
	/**
	 * 娣诲姞楠岃瘉鏂规硶
	 * 浠ュ瓧姣嶅紑澶达紝5-17 瀛楁瘝銆佹暟瀛椼�涓嬪垝绾�_"
	 */
	jQuery.validator.addMethod("user", function(value, element) {   
	    var tel = /^[a-zA-Z][\w]{4,16}$/;
	    return this.optional(element) || (tel.test(value));
	}, "浠ュ瓧姣嶅紑澶达紝5-17 瀛楁瘝銆佹暟瀛椼�涓嬪垝绾�_'");

	$('form[name=register]').validate({
		errorElement : 'span',
		success : function (label) {
			label.addClass('success');
		},
		rules : {
			account : {
				required : true,
				user : true,
				remote : {
					url : checkAccount,
					type : 'post',
					dataType : 'json',
					data : {
						account : function () {
							return $('#account').val();
						}
					}
				}
			},
			pwd : {
				required : true,
				user : true
			},
			pwded : {
				required : true,
				equalTo : "#pwd"
			},
			username : {
				required : true,
				rangelength : [2,10],
				remote : {
					url : checkUname,
					type : 'post',
					dataType : 'json',
					data : {
						uname : function () {
							return $('#username').val();
						}
					}
				}
			},
			verify : {
				required : true,
				remote : {
					url : checkVerify,
					type : 'post',
					dataType : 'json',
					data : {
						verify : function () {
							return $('#verify').val();
						}
					}
				}
			}
		},
		messages : {
			account : {
				required : '璐﹀彿涓嶈兘涓虹┖',
				remote : '璐﹀彿宸插瓨鍦�'
			},
			pwd : {
				required : '瀵嗙爜涓嶈兘涓虹┖'
			},
			pwded : {
				required : '璇风‘璁ゅ瘑鐮�',
				equalTo : '涓ゆ瀵嗙爜涓嶄竴鑷�'
			},
			username : {
				required : '璇峰～鍐欐偍鐨勬樀绉�',
				rangelength : '鏄电О鍦�-10涓瓧涔嬮棿',
				remote : '鏄电О宸插瓨鍦�'
			},
			verify : {
				required : ' ',
				remote : ' '
			}
		}
	});

});