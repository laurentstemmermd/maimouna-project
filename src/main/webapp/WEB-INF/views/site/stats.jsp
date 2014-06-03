<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <h3>Les statistiques</h3>
    <script type="text/javascript">
        google.load("visualization", "1", {packages: ["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Status', '%'],
                <c:forEach items="${stat.statuses}" var="status">
                    ['${status.key}', ${status.value}],
                </c:forEach>
            ]);
            
            var options = {
                title: 'Status depuis toujours',
                slices: {
                  0: { color: 'green' },
                  1: { color: 'red' }
                }
            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
        }
    </script>

    <div id="piechart" style="width: 900px; height: 500px;"></div>

</div>