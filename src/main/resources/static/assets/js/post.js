let main = {
   init : function (e) {
       $(".btn-inverse-primary").on("click", (e)=> {
           this.delete(e);
       });
   },
  
   delete : function (e) {
	   let checkId = e.target.id.replace("delete_", "");

       let data = {
    		   id : $("#id"+ checkId).val()
       };

       $.ajax({
           type : "DELETE",
           url : "/brunch/admin/post/"+ data.id,
           dataType : "json",
           contentType : "application/json; charset=utf-8"
       }).done(function () {
           alert("글이 삭제되었습니다.");
           location.href = "/brunch/admin/post";
       }).fail(function (error) {
           alert("삭제 실패")
           console.log(error);
       })
   }
};

main.init();