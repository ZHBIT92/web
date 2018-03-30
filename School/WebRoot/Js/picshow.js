$(function () {
          $("#add").click(function(){
                $("#form").show();
                $('#bg').show();             
                $('#hide').hide();
          });
          $("#form-close").click(function(){
                $("#form").hide();
                $('#bg').hide();
                $('#hide').show();
          });
});