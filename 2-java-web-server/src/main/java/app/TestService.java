package app;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private DataSource dataSource;

	public TestPojo create(String id) throws Exception {

		TestPojo result = new TestPojo();

		result.setId(id);
		result.setText("Hello " + id);
		result.setDatetime(getDateTime());
		result.setIp(getIp());
		result.setHost(getHostName());

		return result;

	}

	private String getDateTime() throws Exception {

		try (Connection connection = dataSource.getConnection()) {
			try (Statement statement = connection.createStatement()) {

				ResultSet resultSet = statement.executeQuery("SELECT NOW()");
				resultSet.next();
				return resultSet.getObject(1).toString();
			}
		}

	}

	private String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	private String getIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

}
