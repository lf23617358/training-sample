$(function() {
	var alert = $('#alert').hide()
	var modal = $('#modal').modal({
		show : false
	})
	var table = $('#table').bootstrapTable({
		queryParams : function(p) {
			return {
				'limit' : p.limit,
				'offset' : p.offset,
				'sort' : p.sort,
				'order' : p.order,
				'rqObj' : {
					'name' : $('#name').val(),
					'age' : $('#age').val(),
					'country' : $('#country').val()
				}
			}
		},
	})
	// search table data
	$("#queryForm").submit(function(event) {
		event.preventDefault()
		table.bootstrapTable('refresh')
	})
	// show create modal
	$("#createBtn").click(function() {
		showModal($(this).attr('title'));
	})
	// delete table data
	$("#deleteBtn").click(
			function() {
				ajaxUtils('user/removeUser', getIdSelections(), 'delete').done(
						function() {
							table.bootstrapTable('refresh')
							showAlert('Remove item successful!', 'success')
						}).fail(function() {
					showAlert('Remove item error!', 'danger')
				})
			})
	// create or update table data
	$('#submitBtn').click(function() {
		var row = {};
		modal.find('input[name]').each(function() {
			row[$(this).attr('name')] = $(this).val()
		})
		row['id'] = modal.data('id')
		console.log(row)
		if (modal.data('id')) {
			ajaxUtils('user/updateUser', row, 'put').done(function() {
				modal.modal('hide');
				table.bootstrapTable('refresh');
				showAlert('Update item successful!', 'success')
			}).fail(function() {
				modal.modal('hide');
				showAlert('Update item error!', 'danger')
			})
		} else {
			ajaxUtils('user/createUser', row, 'post').done(function() {
				modal.modal('hide');
				table.bootstrapTable('refresh');
				showAlert('Create item successful!', 'success')
			}).fail(function() {
				modal.modal('hide');
				showAlert('Create item error!', 'danger')
			})

		}
	})

	// show update modal
	window.actionEvents = {
		'click .update' : function(e, value, row) {
			showModal($(this).attr('title'), row)
		}
	}

	function showModal(title, row) {
		row = row || {
			id : null,
			name : '',
			age : 0,
			country : ''
		} // default row value
		modal.data('id', row.id);
		modal.find('.modal-title').text(title);
		for ( var name in row) {
			modal.find('input[name="' + name + '"]').val(row[name]);
		}
		modal.modal('show');
	}

	function showAlert(title, type) {
		alert.attr('class', 'alert alert-' + type || 'success').html(
				'<i class="glyphicon glyphicon-check"></i> ' + title).fadeIn(
				"slow").fadeOut(3000);
	}

	function getIdSelections() {
		console.log(table.bootstrapTable('getSelections'));
		return $.map(table.bootstrapTable('getSelections'), function(row) {
			return row.id
		})
	}

})
function ajaxUtils(url, data, method) {
	return $.ajax({
		url : url,
		type : method || 'post',
		contentType : 'application/json',
		data : JSON.stringify(data)
	})
}
function actionFormatter(value, row, index) {
	return '<a class="update" title="Update Item"><i class="glyphicon glyphicon-edit"></i></a>';
}