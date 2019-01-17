package cn.waynechu.renting.core.service.impl;

import cn.waynechu.renting.core.convert.HouseConvert;
import cn.waynechu.renting.core.repository.HouseRepository;
import cn.waynechu.renting.dal.renting.entity.House;
import cn.waynechu.renting.facade.dto.HouseDTO;
import cn.waynechu.renting.facade.service.HouseService;
import cn.waynechu.webcommon.page.PageInfo;
import cn.waynechu.webcommon.util.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhuwei
 * @date 2018/11/14 16:33
 */
@Slf4j
@Service("houseService")
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Cacheable(cacheNames = "houses", key = "#id")
    @Override
    public HouseDTO getById(Long id) {
        HouseDTO returnValue = null;

        House house = houseRepository.getById(id);
        if (house != null) {
            returnValue = HouseConvert.convertHouseDTO(house);
        }
        return returnValue;
    }

    @Override
    public boolean create(HouseDTO houseDTO) {
        boolean returnValue = false;

        House house = HouseConvert.convertHouse(houseDTO);
        if (house != null) {
            returnValue = houseRepository.create(house);
        }
        return returnValue;
    }

    @Override
    public boolean update(HouseDTO houseDTO) {
        boolean returnValue = false;

        House house = HouseConvert.convertHouse(houseDTO);
        if (house != null) {
            returnValue = houseRepository.updateSelective(house);
        }
        return returnValue;
    }

    @Override
    public boolean removeById(Long id) {
        return houseRepository.removeById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean copyByIdTransition(Long id) {
        boolean returnValue = false;

        House copyHouse = houseRepository.getById(id);
        if (copyHouse != null) {
            copyHouse.setId(null);
            returnValue = houseRepository.create(copyHouse);
        }
        return returnValue;
    }

    @Override
    public PageInfo<HouseDTO> search(HouseDTO houseDTO, int pageNum, int pageSize) {
        PageInfo<HouseDTO> returnValue = new PageInfo<>(pageNum, pageSize);

        if (houseDTO != null) {
            House house = HouseConvert.convertHouse(houseDTO);
            PageInfo<House> housePageInfo = houseRepository.query(house, pageNum, pageSize);

            if (CollectionUtil.isNotNullOrEmpty(housePageInfo.getList())) {
                List<HouseDTO> houseDTOS = HouseConvert.convertHouseDTOList(housePageInfo.getList());
                returnValue = housePageInfo.replace(houseDTOS);
            }
        }
        return returnValue;
    }
}