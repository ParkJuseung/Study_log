package com.test.jpa.repository;

import static com.test.jpa.entity.QAddress.address1;
import static com.test.jpa.entity.QInfo.info;
import static com.test.jpa.entity.QMemo.memo1;

import java.util.List;

import com.test.jpa.entity.Info;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.jpa.dto.AddressDTO;
import com.test.jpa.entity.Address;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomAddressRepository {

	private final JPAQueryFactory factory;

	public List<Address> findAll() {
		
		/*
		
			- selectFrom: 해당 엔티티에서 모든 컬럼 조회
				- select a from Address as a
		
			- fetch(): 리스트 조회. 결과가 없으면 빈 리스트 반환
			- fetchOne(): 단일 조회. 레코드(엔티티) 1개 반환. 결과가 다중 레코드면 Exception 발생
			- fetchFirst(): 단일 조회. 레코드(엔티티) 1개 반환. 결과가 다중 레코드면 첫번째 레코드 반환
			- fetchResults(): 페이징 정보 포함
			- fetchCount(): 카운트 반환
		
		*/
		
		return factory
				.selectFrom(address1) 	//SQL 생성 + ResultSet
				.fetch(); 				//selectList() + Mapping
	}

	public Address findByName(String name) {
		
		//레코드 1개 반환
		//- 조건절: where()
		//- select * from tblAddress where name = '강아지'
		
		return factory
				.selectFrom(address1)			//select * from tblAddress
				.where(address1.name.eq(name))	//where name = '강아지'
				.fetchOne();
	}

	public List<String> findName() {

		//모든 컬럼: selectFrom() = select * from
		//특정 컬럼: select() = select 컬럼 from
		
		return factory
				.select(address1.name)	//select *
				.from(address1)			//from tblAddress
				.fetch();				//mapping
	}

	public List<Tuple> findNameAndAgeAndAddress() {
		
		//Type mismatch: cannot convert from List<Tuple> to List<Address>
		
		return factory
				.select(address1.name, address1.age, address1.address)
				.from(address1)
				.fetch();
	}

	public List<AddressDTO> findNameAndAgeAndAddress2() {
		
		//JPA > select 결과 > 엔티티
		//엔티티 > (매핑) > DTO
		
		//1. .select(컬럼) > .select(addrses1.name) > List<String>
		//2. .select(컬럼,컬럼) > .select(address1.name, address1.age) > List<Tuple>
		//3. .select(컬럼,컬럼) > .select(address1.name, address1.age) > List<DTO>
		
		return factory
					.select(Projections.constructor(AddressDTO.class, address1.name, address1.age, address1.address))
					.from(address1)
					.fetch();
	}

	public List<Address> findAddressByGender(String gender) {

		/*
		where 절
		- 동등 비교
			- address1.gender.eq
			- address1.gender.ne
			- address1.address.isNull()
			- address1.address.isNotNull();
		- 열거형
			- address1.age.in(3, 5, 7)
			- address1.age.notIn(3, 5, 7)

		- 범위 비교
			- address1.age.gt(3)
			- address1.age.lt(3)
			- address1.age.goe(3)
			- address1.age.loe(3)
			- address1.age.between(3,5)

		- 패턴
			- address1.address.startsWith("서울특별시")
			- address1.address.endsWith("층")
			- address1.address.contain("빌라")
			- address1.address.like("%아파트%")

		and()
		or()
		not()
		 */


		return factory
				.selectFrom(address1)
				//.where(address1.gender.eq("m"))
				.where(address1.gender.ne("m").and(address1.age.goe(5)).and(address1.address.contains("빌딩")))
				.fetch();
	}

	public List<Address> findAddressOrderBy() {

		/*

		정렬
		- 결과셋.orderBy(정렬기준)

		정렬 기준
		- asc()
		- desc()
		- nullsLast() null인값 맨 아래로
		- nullsFirst() null인값 맨 위로

		 */

		return factory
				.selectFrom(address1)
				.orderBy(address1.age.asc(), address1.gender.asc())
				.fetch();
	}

	public List<Address> findAddressPaging(int offset, int limit) {


		return factory.selectFrom(address1).fetch();
	}

	public Tuple findAddressAggregation() {

		//count(), sum(), avg(), max(), min()

		return factory
				.select(address1.count(), address1.age.avg())
				.from(address1)
				.fetchOne();
	}

	public List<Tuple> fndAddressGroupByGender() {

		return factory
				.select(address1.gender, address1.address.count())
				.from(address1)
				.groupBy(address1.gender)
				.having()
				.fetch();
	}

	public List<Info> findAddressJoinInfo() {
		/*
		조인
		- join()		:inner join()
		- innerJoin()   : inner join()
		- leftJoin()    : left outer join()
		- rightJoin()   : right outer join()
		 */
		return factory
				.selectFrom(info)
				.join(info.address, address1) //join(FK, 부모엔티티)
				.fetch();
	}

	public List<Address> findAddressJoinMemo() {

		return factory.selectFrom(address1)
				.join(address1.memo, memo1)
				.fetch();
	}

	public List<Info> findByAddressFullJoin() {


		return factory.selectFrom(info)
				.join(info.address.address1)
				.join(address1.memo, memo1)
				.where(address1.gender.eq(""))
				.orderBy(address1.seq.asc())
				.fetch();
	}
}











