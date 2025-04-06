




const ctx = document.getElementById('myChart');

// let labels = /*[[${labels}]]*/ [];
// let data = /*[[${qty}]]*/ [];

let data = [2, 3, 4, 5, 6];

const myChart = new Chart (ctx, {
    type: 'bar',
    data: {
        // labels: labels,
        datasets: [{
            data: data,
            label: "qty"

        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Chart.js Bar Chart'
            }
        }
    },
    scales: {
        y: {
            beginAtZero: true
        }
    },
});