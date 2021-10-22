package by.serzhant.webparser.parser;

import by.serzhant.webparser.entity.Gem;

import java.util.List;

public interface Parsable {

    List<Gem> parse(String filePath);
}
