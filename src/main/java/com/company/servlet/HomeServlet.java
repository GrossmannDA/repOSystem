package com.company.servlet;

import com.company.model.Board;
import com.company.model.Boardlist;
import com.company.model.Card;
import com.company.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class HomeServlet extends HttpServlet {

  private static final BoardService BOARD_SERVICE = new BoardService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // get param
    String boardName = req.getParameter("boardName");

    Optional<Board> boardResult = BOARD_SERVICE.findBoardByName(boardName);

    Board board;
    if (!boardResult.isPresent()) {
      // todo: put error on home page if there is no boards

      board = new Board("Simple Board Name");
      Boardlist simpleBoardList = new Boardlist("Simple Board List");
      board.addBoardlist(simpleBoardList);
      simpleBoardList.addListCard(new Card("New Simple Card"));
    } else {
      board = boardResult.get();
    }

    req.setAttribute("board", board);

    req.getRequestDispatcher("/home.jsp").forward(req, resp);
  }
}
