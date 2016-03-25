package com.mydomain.appinsightsconsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;

/**
 * Application Insights Console App
 *
 */
public class App {
	final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		// Application Insights の設定を有効化
		TelemetryConfiguration configuration = TelemetryConfiguration.getActive();
		TelemetryClient telemetryClient = new TelemetryClient(configuration);

		telemetryClient.trackTrace("コンソールアプリからのトレースメッセージ");
		telemetryClient.trackException(new RuntimeException("コンソールアプリの自作例外"), null, null);

		logger.info("Logback 上からのメッセージ");

		// 最後に flush しないとリクエストがメモリ上に滞留したままアプリが終了する
		telemetryClient.flush();

		System.out.println("end");
	}
}
