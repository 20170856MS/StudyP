console.log("fileManager");

//파일의 개수
let count =0;

$("#fileAdd").click(function(){
    if(flag){
        let size = $("#fileAddResult").attr("data-file-size");
        if(size==undefined){
            size=0;
        }
        count=size;
        flag=false;
    }

    if(count<5){
        let r = '<div class="mb-3">';
        r = r+'<label for="contents" class="form-label">File</label>';
        r = r+'<input type="file" name="files">';
        r = r+'<button type="button" class="del">X</button>'
        r = r+'</div>';
        $("#fileAddResult").append(r);
        count++;
    }else {
        alert("최대 5개만 가능")
    } 
});

$("#fileAddResult").on("click", ".del", function(){
    $(this).parent().remove();
    count--;
});