import React from 'react';
import PropTypes from 'prop-types'

function Item(props) {
  const { content, func } = props
  return (
    <div className="Item" onClick={func}>
      {content}
    </div>
  );
}

export default Item;

Item.propTypes = {
  content: PropTypes.string.isRequired,
}
