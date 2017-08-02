var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var logger = require('morgan');
var os = require("os");
var mysql = require('mysql');

var app = express();

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: false
}));
app.use(cookieParser());

function getIp() {
    var ifs = require('os').networkInterfaces();
    return Object.keys(ifs)
        .map(x => ifs[x].filter(x => x.family === 'IPv4' && !x.internal)[0])
        .filter(x => x)[0].address;
}


function getDateTime() {

    return new Promise(function (resolve, reject) {

        var connection = mysql.createConnection(process.env.MYSQL_URL);

        connection.connect(error => {

            if (error) {
                connection.destroy();
                return reject(error);
            }

            connection.query('SELECT NOW()', (error, results, fields) => {

                connection.destroy();

                if (error) return reject(error);

                var date = results[0]['NOW()'];

                return resolve(date);

            });

        });

    });

}

app.get('/test/*', function (req, res, next) {

    var id = req.path.match(/\/([^\/]+)\/?$/)[1];
    var ip = getIp();

    getDateTime().then(date => {

        res.json({
            "id": id,
            "text": "Hello " + id,
            "datetime": date,
            "host": os.hostname(),
            "ip": ip,
        });

    }).catch(error => {
        next(error);
    });

});

// catch 404 and forward to error handler
app.use(function (req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

// error handler
app.use(function (err, req, res, next) {
    // set locals, only providing error in development
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};
    res.status(err.status || 500);
    res.send({
        message: err.message,
        error: err
    });
    return;
});


var env = process.env;

// start server
app.listen(env.NODE_PORT || env.PORT || 3000, function () {
    console.log(`App started on port 3000...`);
});