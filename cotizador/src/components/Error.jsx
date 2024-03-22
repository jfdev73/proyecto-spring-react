import { useCotizadorContext } from '../hooks/useCotizadorContext';

const Error = () => {
	const { error } = useCotizadorContext();
	return (
		<div className='border text-center border-red-400 bg-red-100 py-3 text-red-700'>
			<p>{error}</p>
		</div>
	);
};
export default Error;
