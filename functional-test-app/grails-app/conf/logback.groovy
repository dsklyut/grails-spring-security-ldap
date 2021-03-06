import grails.util.BuildSettings
import grails.util.Environment

appender('STDOUT', ConsoleAppender) {
	encoder(PatternLayoutEncoder) {
		pattern = '%level %logger - %msg%n'
	}
}

//logger 'grails.plugin.springsecurity', TRACE
//logger 'org.springframework.security', DEBUG
//logger 'org.hibernate.SQL', DEBUG
//logger 'org.hibernate.type.descriptor.sql.BasicBinder', TRACE

logger 'org.springframework.security', WARN

root ERROR, ['STDOUT']

File targetDir = BuildSettings.TARGET_DIR
if (Environment.developmentMode && targetDir) {

	appender('FULL_STACKTRACE', FileAppender) {
		file = "$targetDir/stacktrace.log"
		append = true
		encoder(PatternLayoutEncoder) {
			pattern = '%level %logger - %msg%n'
		}
	}

	logger 'StackTrace', ERROR, ['FULL_STACKTRACE'], false
}
