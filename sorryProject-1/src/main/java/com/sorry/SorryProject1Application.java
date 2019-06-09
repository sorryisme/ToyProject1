package com.sorry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

@SpringBootApplication
(scanBasePackages={"com.sorry.*,SQLMap.mapper.board"})
public class SorryProject1Application {

	public static void main(String[] args) {
      SpringApplication.run(SorryProject1Application.class, args);
	}

}
