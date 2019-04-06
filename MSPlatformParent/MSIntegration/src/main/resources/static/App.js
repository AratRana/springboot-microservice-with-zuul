var tabData = [
  { name: 'Overview', isActive: true },
  { name: 'Enterprise', isActive: false },
  { name: 'Role', isActive: false },
  { name: 'Filter', isActive: false },
  { name: 'Resource', isActive: false },
  { name: 'Partnership', isActive: false }
];
var Tabs = React.createClass({
  render: function() {
    return (<ul className="nav nav-tabs">
        {tabData.map(function(tab){
          return (
            <Tab data={tab} isActive={this.props.activeTab === tab} handleClick={this.props.changeTab.bind(this,tab)} />
          );
        }.bind(this))}      
      </ul>
    );
  }
});

var Tab = React.createClass({
  render: function() {
    return (
      <li onClick={this.props.handleClick} className={this.props.isActive ? "active" : null}>
        <a href="#">{this.props.data.name}</a>
      </li>
    );
  }
});
var Content = React.createClass({
  render: function() {
    return (
      <div>
      	{this.props.activeTab.name === 'Overview' ? 
          	<section id="securityTab" className="overviewSection">
      		<table id="tblOverviewDisplay" class="table-0-3 align-left">    	
    			<tr class="align-left">
    				<td style={{width:'90%'}}>Security is essential for sharing of
    					sensitive company data inside and outside your organization.
    					Setting up security involves configuration of the following
    					objects:</td>
    				<td style={{width:'10%'}}></td>
    			</tr>    		
    			<table>
		    		<tbody>
		    			<tr>
		    				<td className='home-page-td'><b>Enterprises</b></td>
		    				<td style={{width:'70%'}}>Define your organization and
		    					organizations with whom you do business</td>
		    			</tr>
		    			<tr class="align-left">
		    				<td className='home-page-td'><b>Roles</b></td>
		    				<td style={{width:'90%'}}>Identify which actions users can
		    					perform and which types of data users can access.</td>
		    			</tr>
		    			<tr class="align-left">
		    				<td className='home-page-td'><b>Filters</b></td>
		    				<td style={{width:'90%'}}>Control which relational data rows
		    					users can access.</td>
		    			</tr>
		    			<tr class="align-left">
		    				<td className='home-page-td'><b>Resources</b></td>
		    				<td style={{width:'90%'}}>Define the resources (tables,
		    					columns, features, and entities) to which access should be
		    					controlled.</td>
		    			</tr>
		    			<tr class="align-left">
		    				<td className='home-page-td'><b>Partnerships</b></td>
		    				<td style={{width:'90%'}}>Define the relationships between
		    					organizations with whom you do business.</td>
		    			</tr>
		    			<tr class="align-left">
		    				<td className='home-page-td'><b>Reports</b></td>
		    				<td style={{width:'90%'}}>Identifies the users logged into the
		    					system.</td>
		    			</tr>
		    		</tbody>
		    	</table>
		    </table>
      		</section>
          :null}      	     
        {this.props.activeTab.name === 'Enterprise' ?
        		<section id="enterpriseTab" className="header-marigin-top">
                        <iframe src="http://apihost:8087/enterpriseserviceui/" width="100%" height="1500px" scrolling="no" style={{border:'0'}} />
                </section>        
        :null}
        {this.props.activeTab.name === 'Role' ?
            	<section id="roleTab">
            		<iframe src="http://apihost:8087/roleserviceui/" width="100%" height="1500px" scrolling="no" style={{border:0}} />
            	</section>
            :null} 
        {this.props.activeTab.name === 'Filter' ? 
        	<section id="filterTab">
        		<iframe src="http://apihost:8087/filters/" width="100%" style={{border:0}} height="700px" scrolling="" />
        	</section>		
        :null} 
        {this.props.activeTab.name === 'Resource' ? 
            	<section id="filterTab" style={{border:1}}>
            		<iframe src="http://apihost:8087/resourceui/" width="100%" height="700px" style={{border:0}} />
            	</section>		
        :null}
        {this.props.activeTab.name === 'Partnership' ? 
            	<section className="home-page" id="filterTab">
            		<iframe src="http://apihost:8087/partnershipui/" width="100%" height="700px" style={{border:0}} />
            	</section>		
        :null}
      </div>
    );
  }
});
var App = React.createClass({
  getInitialState: function() {
    return {
      activeTab: tabData[0]
    }
  }, 
  handleClick: function(tab) {
	  this.setState({activeTab: tab});
  },
  render: function() {
    return (
      <div>
        <Tabs activeTab={this.state.activeTab} changeTab={this.handleClick} />
        <Content activeTab={this.state.activeTab} />
      </div>
    );
  }
});
ReactDOM.render(
  <App />,
  document.getElementById('app')
);