package com.beike.manager;

import com.beike.dao.Board;
import com.beike.dao.BoardDAO;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by CJL on 2015/3/24.
 */
public class BoardManager {

    private static final Logger LOGGER = Logger.getLogger(BoardManager.class);

    private static BoardDAO boardDAO = new BoardDAO();

    public Integer addBoard(Board board) {
        boardDAO.save(board);
        return board.getId();
    }

    public  List<Board> getAllBoards() {
        return boardDAO.findAll();
    }

    public static void main(String[] args) {
        BoardManager boardManager = new BoardManager();
       // System.out.println(boardManager.addBoard(new Board("Sunshine")));
        for(Board board:boardManager.getAllBoards()){
            System.out.println("name="+board.getName());
        }
    }
}
