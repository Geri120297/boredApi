package com.boredAPI.boredApi.LineReader;

import org.jline.terminal.Terminal;

import java.util.List;

public interface LineReaderWrapper {

    String readLine(Terminal terminal, List<String > OPTIONS);
}
