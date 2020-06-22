function a() {
    window.location = '/one.html'
}

function b() {
    x = document.getElementById('x').value;
    y = document.getElementById('y').value;
    console.log(x + " " + y)
}

function c() {
    mp = document.getElementById('mp').innerHTML = 'chetory!?';
}


/*for print window*/
function d() {
    window.print()
}

/*ajax ye fanavati ke ba on mitunim bedoone in ke safhe ro refresh konim ba server dad o setad anjam bedim.*/
function ajaxSend() {
    http = null;
    if (navigator.appName == "Microsoft Internet Explorer") {
        http = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        http = new XMLHttpRequest();
    }
    http.open("POST", "index.jsp", false);
    http.onreadystatechange = function () {
        if (http.readyState == 4) {
            alert(http.responseText);
        }
    }
    http.send();
}