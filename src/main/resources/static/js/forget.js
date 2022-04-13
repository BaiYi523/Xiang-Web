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