var wsServer='http://localhost:8443'
var listenport= "3002"
httpProxy = require('http-proxy');
var express = require('express');
var app = express();

var proxy = httpProxy.createProxyServer();
// serve static content
app.use('/', express.static(__dirname + "/"));
//app.use('/index.html', express.static(__dirname + "/index.html"));
app.use('/',function (req, res) { // proxy all requests
  console.log("proxying GET request", req.url);

  proxy.web(req, res, {target: wsServer}); //sandbox
});


app.listen(listenport, function () {
  console.log('Example app listening on port '+ listenport + '!')
})