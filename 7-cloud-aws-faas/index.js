var os = require("os");
var mysql = require('mysql');

exports.handler = function (event, context, callback) {

    var id = event.pathParameters['id'];
    var ip = getIp();

    getDateTime().then(date => {

        var res = {
            "id": id,
            "text": "Hello " + id,
            "datetime": date,
            "host": os.hostname(),
            "ip": ip,
        };

        callback(null, {
            statusCode: 200,
            body: JSON.stringify(res)
        });

    }).catch(error => {
        callback(null, {
            statusCode: 500,
            body: JSON.stringify(error)
        });
    });

};


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