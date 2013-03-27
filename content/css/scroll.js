// JavaScript Document
var url = "http://" + location.hostname + location.pathname;
$('a[@href*="#"]').click(function() {
var id = this.href.substring(this.href.indexOf('#'),this.href.length);
var hrefUrl = this.href.split(id);
if(hrefUrl[0] == url) {
if(id == '#header') {
$('body').addClass('body');
$('.body').ScrollTo('slow');
$('body').removeClass();
return false;
}else{
$(id).ScrollTo('slow');
return false;
}
}
});