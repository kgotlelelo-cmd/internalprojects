const {format, createLogger, transports} = require('winston');
const {timestamp, combine, printf} = format;

const logFormat = printf(({level, message, timestamp,stack }) =>{
    return `${timestamp} ${level}: ${stack || message}`;
});

const logger = createLogger({
    // level: 'debug',
    format: combine(
        format.colorize(),
        timestamp({ format: 'YYYY-MM-DD HH:mm:ss' }),
        format.errors({ stack: true }),
        logFormat
        ),
    // defaultMeta: { service: 'user-service' },
    transports: [
        new transports.Console()
    ],
  });

  module.exports = logger;