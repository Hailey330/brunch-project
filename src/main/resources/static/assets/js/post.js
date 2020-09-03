let main = {
   init : function () {
       $(".btn-delete").on("click", ()=> {
           this.delete();
       });
   },
  
   delete : function () {
       let data = {
    		   id : $("#id").val()
       };

       $.ajax({
           type : "DELETE",
           url : "/brunch/admin/post/del/"+ data.id,
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