let dayS=["日","一","二","三","四","五","六"]
setInterval("tii()",1)
function tii(){
    let date=new Date()
    let year=date.getFullYear()
    let moth=date.getMonth()+1
    let daty=date.getDate()
    let day=date.getDay()

    let hours=date.getHours()
    let minutes=date.getMinutes()
    let seconds=date.getSeconds()
    if(seconds<10){
        seconds="0"+seconds
    }
    if(minutes<10){
        minutes="0"+minutes
    }
    if(hours<10){
        hours="0"+hours
    }

    document.getElementById("year").innerText=year+"/"+moth+"/"+daty
    document.getElementById("time").innerText="星期"+dayS[day]+" "+hours+":"+minutes+":"+seconds
}
let login = document.getElementById('login');
let register = document.getElementById('register');
let form_box = document.getElementsByClassName('form-box')[0];
let register_box = document.getElementsByClassName('register-box')[0];
let login_box = document.getElementsByClassName('login-box')[0];
// 点击注册按钮事件
register.addEventListener('click', () => {
    form_box.style.transform = 'translateX(80%)';
    login_box.classList.add('hidden');
    register_box.classList.remove('hidden');
})
login.addEventListener('click', () => {
    form_box.style.transform = 'translateX(0%)';
    register_box.classList.add('hidden');
    login_box.classList.remove('hidden');
})