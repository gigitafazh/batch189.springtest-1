<title>Data User</title>

<head>
<script>
	var modeSubmit = 'insert';
	var tabelUser;
	function getFormData($form) {
		var unindexed_array = $form.serializeArray();
		var indexed_array = {};
		$.map(unindexed_array, function(n, i) {
			indexed_array[n['name']] = n['value'];
		});
		return indexed_array;
	}
	function loadData() {
		$.ajax({
			type : 'get',
			url : 'user/',
			success : function(d) {
				tampilkanData(d);
			},
			error : function(d) {
				console.log('Error');
			}
		});
	}
	function tampilkanData(d) {
		tabelUser.clear().draw();
		$(d)
				.each(
						function(index, element) {
							tabelUser.row
									.add(
											[
													element.userID,
													element.nama,
													element.username,
													element.email,
													element.role,
													'<input class="btn btn-default btn-sm" type="button" value="Edit" onclick="load(\''
															+ element.userID
															+ '\')"> &nbsp;'
															+ '<input class="btn btn-danger btn-sm" type="button" value="Hapus" onclick="hapus(\''
															+ element.userID
															+ '\')">' ]).draw();
						})
	}
	function simpan() {
		var method;
		var data = getFormData($('#form-user'));
		if (modeSubmit == 'insert') {
			method = 'post';
		} else {
			method = 'put';
		}
		$.ajax({
			type : method,
			url : 'user/',
			data : JSON.stringify(data),
			contentType : 'application/json',
			success : function(d) {
				loadData();
				modeSubmit = 'insert';
				$('#userID, #nama, #username, #email, #password, #role')
						.val('');
			},
			error : function(d) {
				console.log('Error');
			}
		});
	}
	function hapus(userID) {
		$.ajax({
			type : 'delete',
			url : 'user/' + userID,
			success : function(d) {
				loadData();
			},
			error : function(d) {
				console.log('Error');
			}
		});
	}
	function load(userID) {
		$.ajax({
			type : 'get',
			url : 'user/' + userID,
			success : function(d) {
				$('#userID').val(d.userID);
				$('#nama').val(d.nama);
				$('#username').val(d.username);
				$('#email').val(d.email);
				$('#password').val(d.password);
				$('#role').val(d.role);
				modeSubmit = 'update';
			},
			error : function(d) {
				console.log('Error');
			}
		});
	}
	$(document).ready(function() {
		loadData();
		tabelUser = $('#tabelUser').DataTable();
	});
</script>
</head>

<body>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<form id="form-user">
					<div class="box-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>User ID</label> <input type="text" class="form-control"
										name="userID" id="userID">
								</div>
								<div class="form-group">
									<label>Nama</label> <input type="text" class="form-control"
										name="nama" id="nama">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Username</label> <input type="text" class="form-control"
										name="username" id="username">
								</div>
								<div class="form-group">
									<label>Email</label> <input type="text" class="form-control"
										name="email" id="email">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Password</label> <input type="text" class="form-control"
										name="password" id="password">
								</div>
								<div class="form-group">
									<label>Role</label> <input type="text" class="form-control"
										name="role" id="role">
								</div>
							</div>
						</div>
					</div>

					<div class="box-footer">
						<button type="button" class="btn btn-primary" onclick="simpan()">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">Tabel Data User</h3>
				</div>
				<div class="box-body">
					<table id="tabelUser" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>User ID</th>
								<th>Nama</th>
								<th>Username</th>
								<th>Email</th>
								<th>Role</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>