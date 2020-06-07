const http = require("http");
var url = require("url");
var obj={
    "name":"asd"
}
var app = http.createServer(function (request, response) {
    response.setHeader('Access-Control-Allow-Origin', 'null');
    
    var url_json = url.parse(request.url);
    console.log(request.url)
    var url_str = JSON.stringify(obj);
    if (url_json.path !== "/favicon.ico") {
        response.write(url_str);
        console.log(url_str)
        console.log('-----------------------')
        console.log(url_json.path);
        console.log('-----------------------')
        console.log(request.url)
    }
    response.end();
}).listen(8888, function () {
    console.log('Server running at http://127.0.0.1:8888/');
});