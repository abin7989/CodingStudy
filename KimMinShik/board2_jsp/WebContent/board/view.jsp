<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%!@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link href="/board2_jsp/assets/css/app.css" rel="stylesheet" />
<title>SSAFY</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">
					<mark class="sky">글보기</mark>
				</h2>
			</div>
			<%
				int articleNo = Integer.parseInt(request.getParameter("article_no"));
				StringBuilder sql = new StringBuilder();
				String URL = "jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";

				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					con = DriverManager.getConnection(URL, "ssafy", "ssafy");
					sql.append("select article_no, user_id,subject,content,hit,register_time \n");
					sql.append("from board \n");
					sql.append("where article_no = ? ");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setInt(1, articleNo);
					rs = pstmt.executeQuery();
					if (rs.next()) {
			%>
			<div class="col-lg-8 col-md-10 col-sm-12">
				<div class="row my-2">
					<h2 class="text-secondary px-5"><%=rs.getString("subject") %></h2>
				</div>
				<div class="row">
					<div class="col-md-8">
						<div class="clearfix align-content-center">
							<img class="avatar me-2 float-md-start bg-light p-2"
								src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg" />
							<p>
								<span class="fw-bold"><%=rs.getString("user_id") %></span> <br /> <span
									class="text-secondary fw-light"> <%=rs.getString("register_time") %> 조회
									: <%=rs.getInt("hit") %> </span>
							</p>
						</div>
					</div>
					<div class="col-md-4 align-self-center text-end">댓글 : 17</div>
					<div class="divider mb-3"></div>
					<div class="text-secondary">
						<%=rs.getString("content") %>
					</div>
					<div class="divider mt-3 mb-3"></div>
					<div class="d-flex justify-content-end">
						<button type="button" id="btn-list"
							class="btn btn-outline-primary mb-3">글목록</button>
						<button type="button" id="btn-mv-modify"
							class="btn btn-outline-success mb-3 ms-1">글수정</button>
						<button type="button" id="btn-delete"
							class="btn btn-outline-danger mb-3 ms-1">글삭제</button>
					</div>
				</div>
			</div>
			<%
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						if (con != null)
							con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			%>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script>
		document.querySelector("#btn-list").addEventListener("click",
				function() {
					location.href = "/board2_jsp/board/list.jsp";
				});
		document.querySelector("#btn-mv-modify").addEventListener("click",
				function() {
					alert("글수정하자!!!");
					location.href = "";
				});
		document.querySelector("#btn-delete").addEventListener("click",
				function() {
					alert("글삭제하자!!!");
					location.href = "";
				});
	</script>
</body>
</html>
