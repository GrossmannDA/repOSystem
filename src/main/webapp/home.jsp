<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.company.model.Board" %>
<%@ page import="com.company.model.Boardlist" %>
<%@ page import="com.company.model.Card" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/home.css"/>
    <script src="scripts/home.js"></script>
</head>

<body>
    <div class="board_titel">Board: <b>${board.boardName}</b>

    <c:forEach items="${board.boardlist}" var="boardlist">
        <p>
            <span>Boardlist: <b>${boardlist.boardlistName}</b></span>

            <c:forEach items="${boardlist.listCard}" var="card">
                <p>
                    <span>Card: ${card.cardName}</span>
                </p>
            </c:forEach>

            <div class="add_new_card">Add new card</div>
        </p>
    </c:forEach>
    </div>
</body>
</html>