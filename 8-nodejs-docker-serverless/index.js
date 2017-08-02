var os = require("os");
var mysql = require('mysql');

module.exports = function (req, res, logger) {

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

  }).catch(err => {
    res.status(500).send({
        message: err.message,
        error: err
    });
  });

}

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