function toggle(element) {
	 $('input:checkbox[id="mainCheck_"]').each(function() {
	     if(this.value == "0"){ //값 비교
	            this.checked = true; //checked 처리
	      } 
	 });
    }

let index = { // 메인페이지변경하기(UPDATE)
   init: function(e){ // 이벤트 리스너 바인딩
      $(".btn-inverse-primary").on("click", (e) => { // ()안에 아무 변수가 들어가도 콜백시 그 자리에 오브젝트가 들어감
    	  this.updateById(e);
      });
   },
   
   updateById: function(e){ // 메인페이지변경하기 로직 시작
	   
	   
	   let checkId = e.target.id.replace("mainCheck_", "");
	   console.log(checkId);
	   console.log("e.target:::"+e.target);
	   
//	   $('#mainCheck_'+"").change(function(){
//		     if($(this).attr('checked')){
//		          $(this).val('TRUE');
//		     }else{
//		          $(this).val('FALSE');
//		     }
//		});
//	   console.log("true,false : " + checkId);
//	   
//	   
//      let data = {
//         id:$("#id_"+checkId).val()
//      };
//      $.ajax({
//         type:"UPDATE",
//         url:"/brunch/admin/main/"+data.id, 
//         dataType: "json"// 서버로부터 응답받을 때 데이터 타입
//      }).done(function(){ 
//    		 alert("변경성공");
//    		 location.href="/brunch/admin/main";
//      }).fail(function(){ // 실패시 ajax 통신이 안된 것
//         console.log(error);   
//      })
   }// 메인페이지변경하기(UPDATE) 끝
};

index.init();