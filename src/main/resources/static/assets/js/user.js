let index = { // 삭제하기 
   init: function(e){ // 이벤트 리스너 바인딩
      $(".btn-inverse-primary").on("click", (e) => { // ()안에 아무 변수가 들어가도 콜백시 그 자리에 오브젝트가 들어감
         this.deleteById(e);
      });
   },
   deleteById: function(e){ // 회원삭제 로직 실행
	   console.log(e.target.id);
	   let checkId = e.target.id.replace("delete_", "");
	   console.log(checkId);
	   
      let data = {
         id:$("#id_"+ checkId).val()
      };
      
      $.ajax({
         type:"DELETE",
         url:"/brunch/admin/user/"+ data.id, 
         dataType: "json"// 서버로부터 응답받을 때 데이터 타입
      }).done(function(){ 
    		 alert("회원이 삭제되었습니다.");
    		 location.href="/brunch/admin/user";
      }).fail(function(){ // 실패시 ajax 통신이 안된 것
         console.log(error);   
      })
   }// deleteById
};



index.init();