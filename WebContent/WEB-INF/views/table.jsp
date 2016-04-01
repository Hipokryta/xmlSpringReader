<div class="container">
	<div class="row">
		<h1> First Spring </h1>
		<form class="uploadFile" method="post" enctype="multipart/form-data" action="UploadFile">
			Import From XML or XLSM: <input type="file" name="file">
			<br/><br/><input type="submit" value="Import"> 
			<input class="desc" type="text" name="name" />
		</form>
	</div>
	
	<div class="row">
		  <table width="100%" border="0" margin="0" padding="0"
		   class="row-border tableHeader" id="systemTable">
		   <thead>
		    <tr>
		     <th>id</th>
		     <th>active</th>
		     <th>amount</th>
		     <th>amount period</th>
		     <th>amount type</th>
		     <th>authorization percent</th>
		     <th>from date</th>
		     <th>order number</th>
		     <th>request</th>
		     <th>to date</th>
		     <th>system id</th>
		     <th>Delete</th>
		    </tr>
		   </thead>
		   <tbody>
		   </tbody>
		  </table>
		 
		
	</div>
	<div class="row">
	
		<form class="add-system">
				<div class="row">
					<button type="submit" class="btn btn-success" disabled>Add new</button> 
				</div>
				<div class="row">
					<div class="col-md-6">
						<div>
					    	 <label for="name">id</label>
					    	<input type="text" name="id" id="id" class="required"/>
					    </div>
					    <div>
					    	 <label for="name">active</label>
					    	<input type="text" name="active" id="active" class="required"/>
					    </div>
					    <div>
					    	 <label for="name">amount</label>
					    	<input type="text" name="amount" id="amount" class="required"/>
					    </div>
					    <div>
					    	 <label for="name">amount period</label>
					    	<input type="text" name="amount_period" id="amount_period" class="required"/>
					    </div>
					    <div>
					    	 <label for="name">authorization percent</label>
					    	<input type="text" name="auth" id="auth" class="required"/>
					    </div>
					    
					</div>
					<div class="col-md-6">
						<div>
					    	 <label for="name">from date</label>
					    	<input type="text" name="from_date" id="from_date" class="required"/>
					    </div>
					    <div>
					    	 <label for="name">order number</label>
					    	<input type="text" name="order_number" id="order_number" class="required"/>
					    </div>
					    <div>
					    	 <label for="name">request</label>
					    	<input type="text" name="request" id="request" class="required"/>
					    </div>
					    <div>
					    	 <label for="name">to date</label>
					    	<input type="text" name="to_date" id="to_date" class="required"/>
					    </div>
					    <div>
					    	 <label for="name">system id</label>
					    	<input type="text" name="system_id" id="system_id" class="required"/>
					    </div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>