const EachEditPanel = props => {
  return (
    <div className="panel panel-default panel-color">
      <div className="panel-heading panel-color" onClick={props.openPanelClick}>
        {props.header}
      </div>
      <div className={props.showHidePanel}>
        <table style={{border: '0px'}}>
          <tbody>{props.body}</tbody>
        </table>
      </div>
    </div>
  );
};

class InsertModal extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
				enterpriseArray: [],
				parentEnterprises: []
		};
	}
	
  handleSaveBtnClick = () => {
    const { columns, onSave } = this.props;
    const newEnterprise = {};
    columns.forEach((column, i) => {
    	if(!column.hiddenOnInsert) {
    		newEnterprise[column.field] = this.refs[column.field].value;
    	}
    }, this);

    let newRow = {};
    for (const prop in newEnterprise) {
      if (prop != "button") newRow[prop] = newEnterprise[prop];
    }    
    axios
      .post(
        "/rest/api/security/enterprises/enterprise/add",
        newRow
      )
      .then(response => {       
      });
	  onSave(newRow);
  };
  
   showEnterprises = () => {
	   axios.get("/api/enterprise/hystrix/rest/api/security/enterprises/enterprise/parententerprises").then(response => {			
		   this.setState({enterpriseArray: response.data});
	   });
	   this.state.parentEnterprises = [];
		for (const prop in this.state.enterpriseArray ) {
			this.state.parentEnterprises.push(
					<option key={prop} value={this.state.enterpriseArray[prop]}>{this.state.enterpriseArray[prop]}</option>
			);
		}
   };
   
  render() {
	var fieldsArray = [];
    const {
      onModalClose,
      onSave,
      columns,
      validateState,
      ignoreEditable
    } = this.props;
	
	{columns.map((column, i) => {
	  const {editable, format, field, name, hiddenOnInsert} = column;
	  
	  const error = validateState[field] ? (
		<span className="help-block bg-danger">
		  {validateState[field]}
		</span>
	  ) : null;
		if(!hiddenOnInsert) {
	  if(name === 'Description:') { 
		fieldsArray.push(<tr>
		  <td className="modal-label-td">
			<label className="label-color">{name} </label>
		  </td>                          
		  <td className="modal-field-td">
			<textarea ref={field} rows="4" cols="50" className={" form-control modal-input"}/>
		  </td>
		  {error}
		</tr>);
		} else if (name === 'Parent enterprise: *') {
			fieldsArray.push(<tr>
		  <td className="modal-label-td">
			<label className="label-color">{name} </label>
		  </td>                          
		  <td className="modal-field-td">
			 <select className="form-control modal-input" ref={field} onClick={() => this.showEnterprises()}>        
			 	{this.state.parentEnterprises}
			  </select>
		  </td>
		  {error}
		</tr>);
		} else {
			fieldsArray.push(<tr>
		  <td className="modal-label-td">
			<label className="label-color">{name} </label>
		  </td>                          
		  <td className="modal-field-td">
			<input ref={field} className={" form-control editor edit-text modal-input"} type="text" defaultValue={""}/>
		  </td>
		  {error}
		</tr>);
		}
		}
	})}
	
    return (
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h4>Add Enterprise</h4>
          </div>
          <div className="modal-body">
            <div className="panel panel-default panel-color">
              <div className="panel-heading panel-color">
                Enterprise Information
              </div>
              <div className="panel-body display-block">
                <table>
                  <tbody>
					{fieldsArray}
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div className="modal-footer">
            <button className="btn btn-default" onClick={onModalClose}>Close</button>
            <button className="btn btn-primary" onClick={() => this.handleSaveBtnClick(columns, onSave)}>Save</button>
          </div>
        </div>
      </div>
    );
  }
}

const EditModal = props => {
  const showHideClassName = props.open
    ? "modal display-block fade-in"
    : "modal display-none";
  const showHideInfoPanel = props.openInfoPanel
    ? "panel-body display-block"
    : "panel-body display-none";
  const showHideAppPanel = props.openAppPanel
    ? "panel-body display-block"
    : "panel-body display-none";

  function formatLabel(each) {
    if (each === "contactEmail") {
      each = "Contact e-mail";
    }  else if (each === "parentEnterpriseName") {
    	each = "Parent enterprise";
    } else if (each === "contactName") {
      each = "Contact name";
    } else if (each === "telephone") {
      each = "Telephone";
    } else if (each === "enterpriseName") {
    	each = "Name";
    } else if (each === "ContactName") {
      each = "Contact Name";
    } else if (each === "fax") {
      each = "Fax";
    } else if (each === "address") { 
    	each = "Address";      
    } else if (each === "city") {
      each = "City";
    } else if (each === "locality") {
      each = "Locality";
    } else if (each === "zipCode") {
    	each = "Zip code";
    } else if (each === "description") {
    	each = "Description";
    }
    return each;
  }

  var fieldsArray = [];
  var row = props.row;
  for (const each in row) {
	if (each!= 'enterpriseId' && each != 'parentId' && each!='enterpriseLevel' && each != 'heritage') {  
	if (each === "enterpriseName" || each === "parentEnterpriseName")  {
		fieldsArray.push(
	      <tr>
	        <td className="modal-label-td">
	          <label className="label-color">{formatLabel(each)}</label>
	        </td>
	        <td className="modal-field-td">{row[each]}</td>
	      </tr>
	    );
	} else if (each === "description") {
		fieldsArray.push(
      <tr>
        <td className="modal-label-td">
          <label className="label-color">{formatLabel(each)}</label>
        </td>
        <td className="modal-field-td">
          <textarea key={each} rows="4" cols="50" className={" form-control modal-input"} value={row[each]} id={each}onChange={props.changeValue}/>
        </td>
      </tr>
    );
	} else {
     fieldsArray.push(
      <tr>
        <td className="modal-label-td">
          <label className="label-color">{formatLabel(each)}</label>
        </td>
        <td className="modal-field-td">
          <input key={each} className={" form-control editor edit-text modal-input"} type="text" value={row[each]} id={each}onChange={props.changeValue}/>
        </td>
      </tr>
    );
    }
	}
  }

  return (
    <div className={showHideClassName}>
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h4>Edit Enterprise</h4>
          </div>
          <div className="modal-body">
            <div className="panel-group">
              <EachEditPanel
                header="Enterprise Information"
                buttonId="info"
                showHidePanel={showHideInfoPanel}
                openPanelClick={props.openInfoPanelClick}
                body={fieldsArray}/>
              <EachEditPanel
                header="Application Specific Data"
                buttonId="app"
                showHidePanel={showHideAppPanel}
                openPanelClick={props.openAppPanelClick}
                body="<h4>ViewPoint Sample Application</h4>"/>
            </div>
          </div>
          <div className="modal-footer">
            <button type="button" className="btn btn-default" onClick={props.handleClose}>Close</button>
            <button type="button" className="btn btn-primary" onClick={props.updateData}>Done</button>
          </div>
        </div>
      </div>
    </div>
  );
};

function rowStyleFormat(row, rowIdx) {
  return rowIdx % 2 === 0 ? "checkbook-on" : "checkbook-off";
}

class EnterpriseTable extends React.Component {
  createEnterpriseToolBar = props => {
    return (
      <div style={{ margin: "15px" }}>
        {props.components.btnGroup}
        <div className="col-xs-8 col-sm-4 col-md-4 col-lg-2">
          {props.components.searchPanel}
        </div>
      </div>
    );
  };

  state = {
    open: false,
    openInfoPanel: true,
    openAppPanel: false,
    editRow: [],
    enterprise: [],
    enterpriseOptions: [
		{value: 'JDA', displayValue: 'JDA'},
		{value: 'Polaris', displayValue: 'Polaris Industries inc'}
	]
  };

  componentDidMount() {
    axios.get(this.props.dataUrl).then(response => {
      this.setState({ enterprise: response.data });
    });
  }

  renderShowsTotal(start, to, total) {
    return (
      <p className="totalDetails">
        Records {start} - {to} of {total}
      </p>
    );
  }

  enterpriseField = (column, attr, editorClass, ignoreEditable) => {
    axios.get(this.props.dataUrl).then(response => {
      this.setState({ enterpriseOptions: response.data });
    });
    return (
      <select className={`${editorClass}`} {...attr}>        
        {
    	  this.state.enterpriseOptions.map(enterprise => (
          <option key={enterprise.enterpriseName} value={enterprise.enterpriseName}>{enterprise.enterpriseName}</option>
        ))}       
      </select>
    );
  };

  showModal = row => {
    this.setState({ open: true });
  };

  hideModal = () => {
    this.setState({ open: false });
  };

  updateData = () => {
    this.setState({ open: false });
    axios
      .post(
        "/rest/api/security/enterprises/enterprise/update",
        this.state.editRow
      )
      .then(response => {});
  };
  openInfoPanelClick = () => {
    if (this.state.openInfoPanel) {
      this.setState({ openInfoPanel: false });
    } else {
      this.setState({ openInfoPanel: true });
    }
  };

  openAppPanelClick = () => {
    if (this.state.openAppPanel) {
      this.setState({ openAppPanel: false });
    } else {
      this.setState({ openAppPanel: true });
    }
  };

  changeValue = (event, row) => {
    const entIndex = this.state.enterprise.findIndex(p => {
      return p.enterpriseName == row.enterpriseName;
    });
    const newEnt = { ...this.state.enterprise[entIndex] };
    for (const prop in newEnt) {
      if (prop == event.currentTarget.id) {
        newEnt[prop] = event.currentTarget.value;
      }
    }
    const copyEnt = [...this.state.enterprise];
    copyEnt[entIndex] = newEnt;

    this.setState({
      editRow: newEnt,
      enterprise: copyEnt
    });
  };

  cellButton(cell, row) {
    return (
      <div>
        <EditModal
          open={this.state.open}
          openInfoPanelClick={this.openInfoPanelClick.bind(this)}
          openAppPanelClick={this.openAppPanelClick.bind(this)}
          openAppPanel={this.state.openAppPanel}
          openInfoPanel={this.state.openInfoPanel}
          handleClose={this.hideModal.bind(this)}
          updateData={this.updateData.bind(this)}
          row={this.state.editRow}
          changeValue={event => this.changeValue(event, this.state.editRow)}/>
		  <a className="edit" title="Edit" data-toggle="tooltip"><i className="material-icons" onClick={this.openModal.bind(this, row)}>&#xE254;</i></a>&nbsp;&nbsp;
          <a className="delete" title="Delete" data-toggle="tooltip"><i className="material-icons" onClick={this.onAfterDeleteRow.bind(this, row)}>delete</i></a>           
      </div>
    );
  }

  openModal = row => {
    let newRow = "";
    for (const prop in row) {
      newRow += '"' + prop + '"' + ": " + row[prop] + ",";
    }
    this.setState({
      open: true,
      editRow: row,
      openInfoPanel: true
    });
  };

  onAfterInsertRow = row => {    
    let newRow = "";
    for (const prop in row) {
      newRow += '"' + prop + '"' + ": " + '"' + row[prop] + '"' + ",";
    }
    axios
      .post(
        "/rest/api/security/enterprises/enterprise/add",
        newRow
      )
      .then(response => {});
  };

  onAfterDeleteRow1 = row => {   
	  if (window.confirm("Do you want to delete this item?")) {
		  axios
	      .delete(
	        "/rest/api/security/enterprises/enterprise/delete/" +
	          row.enterpriseName
	      )
	      .then(response => {    
	    	  const entIndex = this.state.enterprise.findIndex(p => {
	    		    		return p.enterpriseName == row.enterpriseName;
	    		   		});
	    		        const copyEnt = [...this.state.enterprise];
	    		        copyEnt.splice(entIndex,1);
	  		            this.setState({enterprise : copyEnt});
	      });
	  }
  };
  
  onAfterDeleteRow = row => {
	      swal({
	        title: "Delete "+row.enterpriseName,
	        text: "Are you sure you want to delete this enterprise?",
	        showCancelButton: true,
	        confirmButtonClass: "btn-primary",
	        confirmButtonText: "Delete",
	        closeOnConfirm: true
	      }, () => {     
	            axios
	            .delete(
	              "/rest/api/security/enterprises/enterprise/delete/" +
	                row.enterpriseName
	            )
	            .then(response => {   
	                const entIndex = this.state.enterprise.findIndex(p => {
	                              return p.enterpriseName == row.enterpriseName;
	                             });
	                          const copyEnt = [...this.state.enterprise];
	                          copyEnt.splice(entIndex,1);
	                            this.setState({enterprise : copyEnt});
	            });
	          })
	    };
  createCustomAddModal = (
    onModalClose,
    onSave,
    columns,
    validateState,
    ignoreEditable
  ) => {
    const attr = {
      onModalClose,
      onSave,
      columns,
      validateState,
      ignoreEditable
    };
    return <InsertModal {...attr} />;
  };

  render() {
    const options = {
      page: 1,
      sizePerPageList: [
        {
          text: "25",
          value: 25
        },
        {
          text: "50",
          value: 50
        },
        {
          text: "100",
          value: 100
        },
        {
          text: "All",
          value: this.state.enterprise.length
        }
      ],
      sizePerPage: 25,
      pageStartIndex: 1,
      paginationSize: 3,
      prePage: "<-",
      nextPage: "->",
      firstPage: "<=",
      lastPage: "=>",
      paginationShowsTotal: this.renderShowsTotal,
      paginationPosition: "top",
      insertText: "Add",
      afterInsertRow: this.onAfterInsertRow,
      toolbar: this.createCustomToolBar,
      insertModal: this.createCustomAddModal
    };

    const selectRowProp = {
      mode: "checkbox",
      hideSelectColumn: true,
      clickToSelect: true,
      bgColor: "#5E747E"
    };

    return (
    	<div>
			<BootstrapTable data= {this.state.enterprise} hover options={options} bordered={false}
			selectRow={selectRowProp} pagination insertRow search editRow={true} trClassName={rowStyleFormat}>		
				<TableHeaderColumn dataField='enterpriseName' isKey dataSort={ true }>Name: * </TableHeaderColumn>
				<TableHeaderColumn dataField='parentEnterpriseName' dataSort={ true } hidden={true}>Parent enterprise: *</TableHeaderColumn>
				<TableHeaderColumn dataField='contactName' dataSort={ true }>Contact name:</TableHeaderColumn>
				<TableHeaderColumn dataField='contactEmail' dataSort={ true }>Contact e-mail:</TableHeaderColumn>
				<TableHeaderColumn dataField='telephone' dataSort={ true }>Telephone:</TableHeaderColumn>
				<TableHeaderColumn dataField='description' dataSort={ true } >Description:</TableHeaderColumn>
				<TableHeaderColumn dataField='fax' dataSort={ true } hidden={true}>Fax:</TableHeaderColumn>
				<TableHeaderColumn dataField='address' dataSort={ true } hidden={true}>Address:</TableHeaderColumn>
				<TableHeaderColumn dataField='city' dataSort={ true } hidden={true}>City:</TableHeaderColumn>
				<TableHeaderColumn dataField='locality' dataSort={ true } hidden={true}>Locality:</TableHeaderColumn>
				<TableHeaderColumn dataField='zipCode' dataSort={ true } hidden={true}>Zip Code:</TableHeaderColumn>
				<TableHeaderColumn dataField='country' dataSort={ true } hidden={true}>Country:</TableHeaderColumn>	
                <TableHeaderColumn dataField='button' dataFormat={this.cellButton.bind(this)} hiddenOnInsert={true}></TableHeaderColumn>			
			</BootstrapTable>            
		</div>
    );
  }
}

ReactDOM.render(
  <EnterpriseTable dataUrl="/api/enterprise/hystrix/rest/api/security/enterprises/all" />,
  document.getElementById("gridData")
);