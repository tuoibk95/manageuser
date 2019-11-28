function validate() {
    var acount = document.getElementById("acount").value;
    let group = document.getElementById("group").value;
    let hoten = document.getElementById("hoten").value;
    let namsinh = document.getElementById("namsinh").value;
    let thangsinh = document.getElementById("thangsinh").value;
    let ngaysinh = document.getElementById("ngaysinh").value;
    let mail = document.getElementById("mail").value;
    let sodienthoai = document.getElementById("sodienthoai").value;
    let matkhau = document.getElementById("matkhau").value;
    let hopdong = document.getElementById("hopdong");
    let thongbao = "";

    if (acount == null || acount == "") {
        thongbao += "<font color = red >Hãy nhâp vào tài khoản của bạn</font><br>";
        submit = false;
    }
    if (group == null || group == "") {
        thongbao += "<font color = red >Hãy chọn vào tên nhóm của bạn</font><br>";
    }
    if (hoten == null || hoten == "") {
        thongbao += "<font color = red > Hãy nhập vào họ và tên của bạn</font><br>";
    }
    if (namsinh == null || namsinh == "" || thangsinh == null || thangsinh == "" || ngaysinh == null || ngaysinh == "") {
        thongbao += "<font color = red >Hãy chọn vào năm sinh của bạn</font><br>";
    }
    if (mail == null || mail == "") {
        thongbao += "<font color = red > Hãy nhập vào email của bạn</font><br>";
    }
    if (sodienthoai == null || sodienthoai == "") {
        thongbao += "<font color = red > Hãy nhập vào sodienthoai của bạn</font><br>";
    }
    if (matkhau == null || matkhau == "") {
        thongbao += "<font color = red > Hãy nhập vào matkhau của bạn</font><br>";
    }
    if (hopdong.checked == false) {
        thongbao += "<font color = red > Hãy chọn vào hopdong của bạn</font><br>";
    }
    if (thongbao != "") {
        document.getElementById("thongbao").innerHTML = thongbao;
        return false;
    }
}

function anhien() {
    let an1 = document.getElementById("an1");
    let an2 = document.getElementById("an2");
    let an3 = document.getElementById("an3");
    let an4 = document.getElementById("an4");

    if (an1.style.visibility === 'visible') {
        an1.style.visibility = 'hidden';
        an2.style.visibility = 'hidden';
        an3.style.visibility = 'hidden';
        an4.style.visibility = 'hidden';
    } else {
        an1.style.visibility = 'visible';
        an2.style.visibility = 'visible';
        an3.style.visibility = 'visible';
        an4.style.visibility = 'visible';
    };
}