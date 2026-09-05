<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>IT Service Request</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef4f8;
        }

        .container {
            width: 500px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.15);
        }

        h1 {
            text-align: center;
            color: #176b87;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            box-sizing: border-box;
            border: 1px solid #bbb;
            border-radius: 6px;
        }

        textarea {
            height: 100px;
        }

        .radio-group {
            margin-top: 8px;
        }

        .radio-group input {
            width: auto;
        }

        .radio-group label {
            display: inline;
            margin-right: 15px;
            font-weight: normal;
        }

        button {
            width: 100%;
            margin-top: 25px;
            padding: 12px;
            background: #176b87;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>IT Service Request</h1>

    <form action="ServiceRequestServlet" method="post">

        <label>Employee ID</label>
        <input type="text" name="employeeId" required>

        <label>Employee Name</label>
        <input type="text" name="employeeName" required>

        <label>Department</label>
        <input type="text" name="department" required>

        <label>Problem Category</label>
        <select name="problemCategory" required>
            <option value="">Select Category</option>
            <option value="Network">Network</option>
            <option value="Software">Software</option>
            <option value="Hardware">Hardware</option>
            <option value="Account">Account</option>
            <option value="Other">Other</option>
        </select>

        <label>Problem Description</label>
        <textarea name="problemDescription"
                  placeholder="Describe your problem"
                  required></textarea>

        <label>Priority</label>

        <div class="radio-group">
            <label>
                <input type="radio" name="priority" value="Low" required>
                Low
            </label>

            <label>
                <input type="radio" name="priority" value="Medium">
                Medium
            </label>

            <label>
                <input type="radio" name="priority" value="High">
                High
            </label>
        </div>

        <button type="submit">
            Submit Service Request
        </button>

    </form>

</div>

</body>
</html>